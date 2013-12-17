Ext.define('HS.view.comboBox.ItemComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.itemcombobox',
	fieldLabel: 'Select item',
	displayField: 'name',
	valueField: 'itemId',
	name:'itemDTO.itemId',
	/*width: 400,
	labelWidth: 100,*/
	store: 'ItemStore',
	queryModel: 'remote'
})