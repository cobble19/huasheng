Ext.define('HS.view.category.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.categoryedit',
	
	title: '类别编辑',
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
						fieldLabel: '类别唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '类型名称'
					}/*, 
					{
						xtype: 'textfield',
						name: 'topicDTO.topicId',
						fieldLabel: 'Topic Id'
					}*/, 
					{
						xtype: 'topiccombobox'/*,
						name: 'topicDTO.topicId',
						fieldLabel: 'Topic Id'*/
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