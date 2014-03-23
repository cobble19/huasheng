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
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'categoryDTOSearch.name',
			fieldLabel: '主题名称',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'CategoryStore',   // same store GridPanel is using
        dock: 'bottom',
        displayInfo: true
    }],
	tbar: [
	{
		xtype: 'button',
		text: '查询',
		action: 'search'
	},
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