Ext.define('ITEM.view.item.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.itemlist',
	
	title: 'Item List',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'ItemStore',
	tbar: [
	{
		xtype: 'button',
		text: 'Add',
		action: 'add'
	},
	{
		xtype: 'button',
		text: 'Update',
		action: 'update'
	},
	{
		xtype: 'button',
		text: 'Delete',
		action: 'delete'
	}
	],
	initComponent: function() {
		this.columns = [
		{xtype: 'rownumberer'},
		{
			header: 'Item Id',
			dataIndex: 'itemId',
			flex: 1
		}, 
		{
			header: 'Name',
			dataIndex: 'name',
			flex: 1
		}, 
		{
			header: 'Category Id',
			dataIndex: 'categoryDTO.categoryId',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})