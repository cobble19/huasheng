Ext.define('HS.view.menuTree.List', {
	extend: 'Ext.tree.Panel',
	alias: 'widget.menutreelist',
	title: 'Menu Tree',
	width: 150,
	minSize: 150,
	rootVisible: false,
	autoScroll: true,
	store: 'MenuTreeStore', 
	initComponent: function() {
		
		this.callParent(arguments);
	}
	
})