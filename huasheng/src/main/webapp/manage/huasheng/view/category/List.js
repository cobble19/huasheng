Ext.define('HS.view.category.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.categorylist',
	
	title: 'Category List',
	id: 'category-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'CategoryStore',
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
		{
			xtype: 'rownumberer',
			align: 'center'
		},
		{
			header: 'Category Id',
			dataIndex: 'categoryId',
			flex: 1
		}, 
		{
			header: 'Name',
			dataIndex: 'name',
			flex: 1
		}, 
		{
			header: 'Topic Id',
			dataIndex: 'topicDTO.topicId',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})