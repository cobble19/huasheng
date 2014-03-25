Ext.define('HS.view.comboBox.ItemComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.itemcombobox',
	fieldLabel: '选择影视',
	displayField: 'name',
	valueField: 'itemId',
	name:'itemDTO.itemId',
	width: 350,
	//labelWidth: 100,
	store: 'ItemStore',
	queryModel: 'remote',
	minChars: 1,
	pageSize: 10
})