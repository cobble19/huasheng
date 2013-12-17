Ext.define('HS.view.comboBox.TopicComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.topiccombobox',
	fieldLabel: 'Select topic',
	displayField: 'name',
	valueField: 'topicId',
	name:'topicDTO.topicId',
	/*width: 400,
	labelWidth: 100,*/
	store: 'TopicStore',
	queryModel: 'remote'
})