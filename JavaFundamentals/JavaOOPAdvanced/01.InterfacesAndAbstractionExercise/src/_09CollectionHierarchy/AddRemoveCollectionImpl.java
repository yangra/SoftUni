package _09CollectionHierarchy;

public class AddRemoveCollectionImpl extends AddCollectionImpl implements AddRemoveCollection {

    @Override
    public int add(String element) {
        super.getList().add(0,element);
        return 0;
    }

    @Override
    public String remove() {
        String element = super.getList().remove(super.getList().size()-1);
        return element;
    }
}
