Ext.define('HS.view.comboBox.CategoryComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.categorycombobox',
	fieldLabel: '选择类别',
	displayField: 'name',
	valueField: 'categoryId',
	name:'categoryDTO.categoryId',
	width: 350,
	//labelWidth: 100,
	store: 'CategoryStore',
	queryModel: 'remote',
	minChars: 1,
	pageSize: 10
})