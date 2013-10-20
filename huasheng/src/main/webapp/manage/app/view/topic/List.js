Ext.define('MNG.view.topic.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.topiclist',
	title: 'Topic',
	store: 'TopicStore',
	tbar: [
		{
			xtype: 'button',
			text: 'add'
		},
		{
			xtype: 'button',
			text: 'update'
		},
		{
			xtype: 'button',
			text: 'delete'
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
			{header: 'TopicId', dataIndex: 'topicId', flex: 1},
			{header: 'name', dataIndex: 'name', flex: 1}
		];
		this.callParent(arguments);
			
	}
});