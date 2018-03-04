import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final int DIMENSIONS = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int clusters = Integer.parseInt(reader.readLine());
        int reports = Integer.parseInt(reader.readLine());
        int galaxySize = Integer.parseInt(reader.readLine());

        Cluster[] allClusters = new Cluster[clusters];
        for (int i = 0; i < clusters; i++) {
            String[] params = reader.readLine().split(" ");
            Point2D coords = new Point2D(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
            Cluster cluster = new Cluster(params[0], coords);

            if (cluster.getCoords().getX() > galaxySize || cluster.getCoords().getY() > galaxySize) {
                continue;
            }
            allClusters[i] = cluster;
        }

        KdTree tree = new KdTree();
        fillTree(tree, allClusters, 0);
        String debug = "";

        for (int i = 0; i < reports; i++) {
            String[] params = reader.readLine().split(" ");
            Point2D upLeftCorner = new Point2D(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
            Area area = new Area(upLeftCorner, Double.parseDouble(params[3]), Double.parseDouble(params[4]));
            report(area, tree, galaxySize);
        }
    }

    private static void fillTree(KdTree tree, Cluster[] clusters, int depth) {

        if (clusters.length == 0) {
            return;
        }

        int axis = depth % DIMENSIONS;

        clusters = mergeSort(clusters, axis, 0, clusters.length - 1);
        int medianIndex = clusters.length / 2;
        Cluster median = clusters[medianIndex];
        Cluster[] leftSubArray = new Cluster[medianIndex];
        Cluster[] rightSubArray = clusters.length % 2 == 0 ? new Cluster[medianIndex - 1] : new Cluster[medianIndex];


        for (int i = 0; i < clusters.length; i++) {
            if (i < medianIndex) {
                leftSubArray[i] = clusters[i];
            }
            if (i > medianIndex) {
                rightSubArray[i - medianIndex - 1] = clusters[i];
            }
        }

        tree.insert(median.getCoords());
        fillTree(tree, leftSubArray, depth + 1);
        fillTree(tree, rightSubArray, depth + 1);
    }

    private static Cluster[] mergeSort(Cluster[] clusters, int axis, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(clusters, axis, left, mid);
            mergeSort(clusters, axis, mid + 1, right);

            merge(clusters, axis, left, mid, right);
        }

        return clusters;
    }

    private static void merge(Cluster[] clusters, int axis, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        for (int i = 0; i <= Math.min(right - mid + 1, mid - left + 1); i++) {
            if (axis == 0 ? clusters[leftIndex].getCoords().getX() < clusters[rightIndex].getCoords().getX() :
                    clusters[leftIndex].getCoords().getY() < clusters[rightIndex].getCoords().getY()) {
                leftIndex++;
            } else {
                Cluster temp = clusters[rightIndex];
                for (int j = rightIndex; j > leftIndex; j--) {
                    clusters[j] = clusters[j - 1];
                }
                clusters[leftIndex] = temp;
                leftIndex++;
            }
        }
    }

    private static void swap(Cluster[] clusters, int first, int second) {
        Cluster temp = clusters[first];
        clusters[first] = clusters[second];
        clusters[second] = temp;
    }


    private static void report(Area area, KdTree tree, int galaxySize) {
        System.out.println(tree.searchRange(area, galaxySize));
    }
}
