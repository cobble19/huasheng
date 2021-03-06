Ext.define('HS.view.topic.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.topiclist',
	title: '主题列表',
	id: 'topic-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'/*,
		checkOnly: true*/
	},
	store: 'TopicStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'topicDTOSearch.name',
			fieldLabel: '主题名称',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'TopicStore',   // same store GridPanel is using
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
			{header: '主题唯一标识', dataIndex: 'topicId', flex: 1},
			{header: '主题名称', dataIndex: 'name', flex: 1}
		];
		this.callParent(arguments);
			
	}
});