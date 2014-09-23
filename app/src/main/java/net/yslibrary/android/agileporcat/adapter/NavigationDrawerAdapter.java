package net.yslibrary.android.agileporcat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.yslibrary.android.agileporcat.R;
import net.yslibrary.android.agileporcat.enums.DrawerItemType;
import net.yslibrary.android.agileporcat.enums.DrawerMenu;


/**
 * Created by shimizu_yasuhiro on 2014/08/22.
 */
public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerAdapter.NavItem> {



    public static class NavItem {

        private String title;

        private DrawerItemType itemType;

        private DrawerMenu drawerMenu;

        NavItem(String title, DrawerItemType itemType, DrawerMenu drawerMenu) {
            this.title = title;
            this.itemType = itemType;
            this.drawerMenu = drawerMenu;
        }

        /**
         * メニュー用
         * @param title
         */
        NavItem(String title, DrawerMenu drawerMenu) {
            this(title, DrawerItemType.MENU, drawerMenu);
        }

        public DrawerMenu getDrawerMenu() {
            return this.drawerMenu;
        }
    }

    public static class HeaderViewHolder {
        TextView title;
    }

    public static class MenuViewHolder {
        TextView title;
    }

    public NavigationDrawerAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).itemType.getValue();
    }

    @Override
    public boolean isEnabled(int position) {
        return getItem(position).itemType != DrawerItemType.HEADER;
    }

    @Override
    public int getViewTypeCount() {
        return DrawerItemType.values().length;
    }

    public void addHeader(String title, DrawerMenu drawerMenu) {
        add(new NavItem(title, DrawerItemType.HEADER, drawerMenu));
    }


    public void addMenu(String title, DrawerMenu drawerMenu) {
        add(new NavItem(title, drawerMenu));
    }

    public void addItem(NavItem navItem) {
        add(navItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = this.getItemViewType(position);
        DrawerItemType itemType = DrawerItemType.values()[viewType];

        switch (itemType) {
            case MENU:  // メニュー

                MenuViewHolder menuViewHolder;

                if (convertView == null) {
                    LayoutInflater li = LayoutInflater.from(getContext());

                    convertView = li.inflate(R.layout.drawer_menu, parent, false);
                    menuViewHolder = new MenuViewHolder();

                    menuViewHolder.title = (TextView) convertView.findViewById(R.id.drawer_menu);

                    convertView.setTag(menuViewHolder);

                } else {
                    menuViewHolder = (MenuViewHolder) convertView.getTag();
                }

                NavItem item = getItem(position);

                menuViewHolder.title.setText(item.title);

                return convertView;

            case HEADER:    // ヘッダー

                HeaderViewHolder headerViewHolder;

                if (convertView == null) {
                    LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    convertView = li.inflate(R.layout.drawer_header, parent, false);
                    headerViewHolder = new HeaderViewHolder();
                    headerViewHolder.title = (TextView) convertView.findViewById(R.id.drawer_header);

                    convertView.setTag(headerViewHolder);

                } else {
                    headerViewHolder = (HeaderViewHolder) convertView.getTag();
                }

                NavItem headerItem = getItem(position);

                headerViewHolder.title.setText(headerItem.title);

                return convertView;

            default:
                throw new IllegalArgumentException("Unknown Data Type.");
        }
    }
}