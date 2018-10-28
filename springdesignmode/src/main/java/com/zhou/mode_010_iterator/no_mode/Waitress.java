/**
 * Date:     2018/10/2822:36
 * AUTHOR:   Administrator
 */
package com.zhou.mode_010_iterator.no_mode;

import java.util.List;

/**
 * 2018/10/28  22:36
 * created by zhoumb
 */
public class Waitress {
    private CakeHouseMenu cakeHouseMenu;
    private List<MenuItem> cakeHouseMenus;

    private DinerMenu dinerMenu;
    private MenuItem[] dinerMenus;

    public Waitress() {
        cakeHouseMenu = new CakeHouseMenu();
        cakeHouseMenus = cakeHouseMenu.getMenuItems();

        dinerMenu = new DinerMenu();
        dinerMenus = dinerMenu.getMenuItems();
    }
}
