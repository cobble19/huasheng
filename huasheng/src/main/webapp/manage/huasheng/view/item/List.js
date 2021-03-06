Ext.define('HS.view.item.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.itemlist',
	
	title: '影视列表',
	id: 'item-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'ItemStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'itemDTOSearch.name',
			fieldLabel: '主题名称',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'ItemStore',   // same store GridPanel is using
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
		{xtype: 'rownumberer'},
		{
			header: '影视唯一标识',
			dataIndex: 'itemId',
			flex: 1
		}, 
		{
			header: '影视名称',
			dataIndex: 'name',
			flex: 1
		}, 
		{
			header: '点击数',
			dataIndex: 'hits',
			flex: 1
		}, 
		{
			header: '地区名称',
			dataIndex: 'areaName',
			flex: 1
		}, 
		{
			header: '上映日期',
			dataIndex: 'showDate',
			xtype: 'datecolumn',
			format: 'Y-m-d',
			flex: 1
		}, 
		{
			header: '上映年份',
			dataIndex: 'year',
			flex: 1
		}, 
		{
			header: '评分',
			dataIndex: 'score',
			flex: 1
		}, 
		{
			header: '简介',
			dataIndex: 'description',
			flex: 1
		}, 
		{
			header: '演员名称',
			dataIndex: 'actorName',
			flex: 1
		}, 
		{
			header: '类型',
			dataIndex: 'itemType',
			flex: 1
		}, 
		{
			header: '导演',
			dataIndex: 'director',
			flex: 1
		}, 
		{
			header: '图片',
			dataIndex: 'imgUrl',
			flex: 1
		}, 
		{
			header: '类别唯一标识',
			dataIndex: 'categoryDTO.categoryId',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})