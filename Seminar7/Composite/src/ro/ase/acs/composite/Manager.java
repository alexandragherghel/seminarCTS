package ro.ase.acs.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements HierarchicalNode{
    private float salary;
    private String name;
    private List<HierarchicalNode> list = new ArrayList<>();

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addHierarchicalNode(HierarchicalNode node) {
        list.add(node);
    }

    @Override
    public void deleteHierarchicalNode(HierarchicalNode node) {
        list.remove(node);
    }

    @Override
    public HierarchicalNode searchNodeByName(String name) {
        for (HierarchicalNode node : list) {
            if(node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(System.lineSeparator());
        for (HierarchicalNode node : list) {
            stringBuilder.append("|");
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("- ");
            stringBuilder.append(node.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
