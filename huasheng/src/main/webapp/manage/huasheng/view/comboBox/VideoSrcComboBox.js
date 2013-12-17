Ext.define('HS.view.comboBox.VideoSrcComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.videosrccombobox',
	fieldLabel: 'Select VideoSrc',
	displayField: 'name',
	valueField: 'videoSrcId',
	name:'videoSrcDTO.videoSrcId',
	/*width: 400,
	labelWidth: 100,*/
	store: 'VideoSrcStore',
	queryModel: 'remote'
})