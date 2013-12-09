Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: 'VIDEO',
	appFolder: 'video',
	controllers: [
		'VideoController'
	],
	launch: function() {
		console.log('video.js');
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [{
				xtype: 'videolist'
			}]
		})
	}
})