package ro.ase.acs.composite;

public interface HierarchicalNode {
    public float getSalary();
    public String getName();
    public void addHierarchicalNode(HierarchicalNode node);
    public void deleteHierarchicalNode(HierarchicalNode node);

    default public HierarchicalNode searchNodeByName(String name) {
        throw new UnsupportedOperationException();
    }
}
