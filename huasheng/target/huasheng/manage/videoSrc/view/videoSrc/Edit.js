Ext.define('VS.view.videoSrc.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.videoSrcedit',
	
	title: 'VideoSrc Edit',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'videoSrcId',
						fieldLabel: 'VideoSrc Id'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: 'Name'
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