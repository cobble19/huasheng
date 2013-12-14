Ext.define('HS.view.video.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.videoedit',
	
	title: 'Video Edit',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'videoId',
						fieldLabel: 'Video Id'
					}, 
					{
						xtype: 'textfield',
						name: 'url',
						fieldLabel: 'URL'
					}, 
					{
						xtype: 'textfield',
						name: 'orderNum',
						fieldLabel: 'OrderNum'
					}, 
					{
						xtype: 'textfield',
						name: 'itemDTO.itemId',
						fieldLabel: 'Item Id'
					}, 
					{
						xtype: 'textfield',
						name: 'videoSrcDTO.videoSrcId',
						fieldLabel: 'VideoSrc Id'
					}
				]
			}
		];
		this.buttons = [
		{
			text: 'Add',
			action: 'add',
			id: 'btnAdd'
		},
		{
			text: 'Update',
			action: 'update',
			id: 'btnUpdate'
		}, 
		{
			text: 'Cancel',
			scope: this,
			handler: this.close
		}
		];
		this.callParent(arguments);
	}
})