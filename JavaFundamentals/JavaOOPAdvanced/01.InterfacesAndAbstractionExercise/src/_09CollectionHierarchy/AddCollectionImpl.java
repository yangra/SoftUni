package _09CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl implements AddCollection {
    private List<String> list;

    public AddCollectionImpl() {
        this.list = new ArrayList<>();
    }

    protected List<String> getList() {
        return this.list;
    }

    @Override
    public int add(String element) {
        this.list.add(element);
        return this.list.size() - 1;
    }
}
