Ext.define('HS.view.item.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.itemlist',
	
	title: 'Item List',
	id: 'item-list',
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
			header: 'Hits',
			dataIndex: 'hits',
			flex: 1
		}, 
		{
			header: 'Area Name',
			dataIndex: 'areaName',
			flex: 1
		}, 
		{
			header: 'Show Date',
			dataIndex: 'showDate',
			flex: 1
		}, 
		{
			header: 'Score',
			dataIndex: 'score',
			flex: 1
		}, 
		{
			header: 'Description',
			dataIndex: 'description',
			flex: 1
		}, 
		{
			header: 'Actor Name',
			dataIndex: 'actorName',
			flex: 1
		}, 
		{
			header: 'Item Type',
			dataIndex: 'itemType',
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