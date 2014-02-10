Ext.define('HS.view.menuTree.List', {
	extend: 'Ext.tree.Panel',
	alias: 'widget.menutreelist',
	title: '菜单功能',
	width: 150,
	minSize: 150,
	rootVisible: false,
	autoScroll: true,
	store: 'MenuTreeStore', 
	activeItem: 1,
	initComponent: function() {
		
		this.callParent(arguments);
	}
	
})