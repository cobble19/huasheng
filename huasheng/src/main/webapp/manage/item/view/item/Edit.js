Ext.define('ITEM.view.item.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.itemedit',
	
	title: 'Item Edit',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'itemId',
						fieldLabel: 'Item Id'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: 'Name'
					}, 
					{
						xtype: 'textfield',
						name: 'categoryDTO.categoryId',
						fieldLabel: 'Category Id'
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