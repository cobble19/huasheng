Ext.define('HS.view.item.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.itemedit',
	
	title: '影视编辑',
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
						fieldLabel: '影视唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '影视名称'
					}, 
					{
						xtype: 'textfield',
						name: 'hits',
						fieldLabel: '点击率'
					}, 
					{
						xtype: 'textfield',
						name: 'areaName',
						fieldLabel: '地区'
					}, 
					{
						xtype: 'textfield',
						name: 'showDate',
						fieldLabel: '上映时间'
					}, 
					{
						xtype: 'textfield',
						name: 'score',
						fieldLabel: '评分'
					}, 
					{
						xtype: 'textfield',
						name: 'description',
						fieldLabel: '描述'
					}, 
					{
						xtype: 'textfield',
						name: 'actorName',
						fieldLabel: '演员'
					}, 
					{
						xtype: 'textfield',
						name: 'itemType',
						fieldLabel: '影视类别'
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
			text: '添加',
			action: 'add',
			id: 'btnAdd'
		},
		{
			text: '修改',
			action: 'update',
			id: 'btnUpdate'
		}, 
		{
			text: '取消',
			scope: this,
			handler: this.close
		}
		];
		this.callParent(arguments);
	}
})