Ext.define('HS.view.topic.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.topiclist',
	title: 'Topic',
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
			text: 'add',
			action: 'add'
		},
		{
			xtype: 'button',
			text: 'update',
			action: 'update'
		},
		{
			xtype: 'button',
			text: 'delete',
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
			{header: 'TopicId', dataIndex: 'topicId', flex: 1},
			{header: 'name', dataIndex: 'name', flex: 1}
		];
		this.callParent(arguments);
			
	}
});