package com.wsmhz.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By tangbj On 2019/7/13
 * Description:
 */
public class CodeCatalog extends CatalogComponent {

    private List<CatalogComponent> catalogComponentList = new ArrayList<CatalogComponent>();

    private String name;

    private Integer level;

    public CodeCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        catalogComponentList.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        catalogComponentList.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : catalogComponentList) {
            if(this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
            }
            catalogComponent.print();
        }
    }
}
