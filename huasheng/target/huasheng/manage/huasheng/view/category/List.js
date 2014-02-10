Ext.define('HS.view.category.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.categorylist',
	
	title: '类别列表',
	id: 'category-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'CategoryStore',
	tbar: [
	{
		xtype: 'button',
		text: '添加',
		action: 'add'
	},
	{
		xtype: 'button',
		text: '修改',
		action: 'update'
	},
	{
		xtype: 'button',
		text: '删除',
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
			header: '类别唯一标识',
			dataIndex: 'categoryId',
			flex: 1
		}, 
		{
			header: '类型名称',
			dataIndex: 'name',
			flex: 1
		},  
		{
			header: '排序',
			dataIndex: 'orderNo',
			flex: 1
		}, 
		{
			header: '主题唯一标识',
			dataIndex: 'topicDTO.topicId',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})