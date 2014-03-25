Ext.define('HS.view.comboBox.TopicComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.topiccombobox',
	fieldLabel: '选择主题',
	displayField: 'name',
	valueField: 'topicId',
	name:'topicDTO.topicId',
	width: 350,
	//labelWidth: 100,
	store: 'TopicStore',
	queryModel: 'remote',
	minChars: 1,
	pageSize: 10
})