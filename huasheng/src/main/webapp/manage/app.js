Ext.application({
	requires: ['Ext.container.Viewport'],
	name: 'MNG',
	appFolder: 'app',
	controllers: [
		'TopicController'
	],
	launch: function() {
		Ext.create('Ext.container.Viewport', {
			layout: "fit",
			items: [
				{
					xtype: 'topiclist'
				}
				/*{
					xtype: "panel",
					title: "manage index",
					html: "manage index content"
				}*/
			]
		});
	}
});