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
		/*this.store = {
			fields: ['topicId', 'name'],
			data: [
				{topicId: 1, name: 'topic_name1'},
				{topicId: 2, name: 'topic_name2'}
			]
		};*/
		this.columns = [
			{xtype: 'rownumberer'},
			{header: '主题唯一标识', dataIndex: 'topicId', flex: 1},
			{header: '主题名称', dataIndex: 'name', flex: 1}
		];
		this.callParent(arguments);
			
	}
});