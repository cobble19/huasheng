Ext.define('HS.view.item.Edit', {
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
						name: 'hits',
						fieldLabel: 'Hits'
					}, 
					{
						xtype: 'textfield',
						name: 'areaName',
						fieldLabel: 'Area Name'
					}, 
					{
						xtype: 'textfield',
						name: 'showDate',
						fieldLabel: 'Show Date'
					}, 
					{
						xtype: 'textfield',
						name: 'score',
						fieldLabel: 'Score'
					}, 
					{
						xtype: 'textfield',
						name: 'description',
						fieldLabel: 'Description'
					}, 
					{
						xtype: 'textfield',
						name: 'actorName',
						fieldLabel: 'Actor Name'
					}, 
					{
						xtype: 'textfield',
						name: 'itemType',
						fieldLabel: 'Item Type'
					}/*, 
					{
						xtype: 'textfield',
						name: 'categoryDTO.categoryId',
						fieldLabel: 'Category Id'
					}*/,
					{
						xtype: 'categorycombobox'
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