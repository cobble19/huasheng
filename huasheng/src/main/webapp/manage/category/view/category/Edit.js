Ext.define('CATEG.view.category.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.categoryedit',
	
	title: 'Category Edit',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'categoryId',
						fieldLabel: 'Category Id'
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