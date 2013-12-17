Ext.define('HS.view.comboBox.CategoryComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.categorycombobox',
	fieldLabel: 'Select category',
	displayField: 'name',
	valueField: 'categoryId',
	name:'categoryDTO.categoryId',
	/*width: 400,
	labelWidth: 100,*/
	store: 'CategoryStore',
	queryModel: 'remote'
})