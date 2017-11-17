package _09CollectionHierarchy;

public class MyListImpl extends AddRemoveCollectionImpl implements MyList {

    @Override
    public String remove() {
        String element = super.getList().remove(0);
        return element;
    }

    @Override
    public int used() {
        return super.getList().size();
    }
}
