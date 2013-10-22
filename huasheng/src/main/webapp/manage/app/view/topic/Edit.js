Ext.define('MNG.view.topic.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.topicedit',
	
	title: 'Edit Topic',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'topicId',
						fieldLabel: 'TopicId'
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
				text: 'Save',
				action: 'save',
				id: 'btnSave'
			},
			{
				text: 'Add',
				action: 'add',
				id: 'btnAdd'
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