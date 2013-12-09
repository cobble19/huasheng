Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: 'VS',
	appFolder: 'videoSrc',
	controllers: [
		'VideoSrcController'
	],
	launch: function() {
		console.log('videoSrc.js');
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [{
				xtype: 'videoSrclist'
			}]
		})
	}
})