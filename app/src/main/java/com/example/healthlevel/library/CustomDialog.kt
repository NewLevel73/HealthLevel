package com.example.healthlevel.library

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthlevel.R
import com.example.healthlevel.databinding.StandardGetterDialogBinding
import com.example.healthlevel.databinding.StandardListDialogItemBinding
import com.example.healthlevel.databinding.StandardListDialogBinding

fun getStandardGetterDialog(context: Context, title: String = "", description: String = "", onClickListener: (() -> Unit)? = null): Dialog {
    val dialog = Dialog(context)
    val model = StandardGetterDialogModel(title, description) {
        onClickListener?.invoke()
        dialog.dismiss()
    }
    val binding = DataBindingUtil.inflate<StandardGetterDialogBinding>(context.layoutInflater,
        R.layout.standard_getter_dialog, null, false)
    binding.model = model
    dialog.setContentView(binding.root)
    return dialog
}

class StandardGetterDialogModel(title: String = "", description: String = "", listener: (() -> Unit)? = null) {
    var titleText: String = title
    var descriptionText: String = description
    var okButtonListener: (() -> Unit)? = listener

    fun okButtonClick() {
        okButtonListener?.invoke()
    }
}

fun getStandardListDialog(context: Context, items: Array<String>, title: String = "", onClickListener: (Dialog, Int) -> Unit): Dialog {
    val dialog = if (title.isBlank()) Dialog(context, R.style.CustomDialogWithoutTitle) else Dialog(context)
    dialog.setTitle(title)
    val model =  StandardListDialogModel().apply {
        adapter.apply {
            this.items = items
            this.onClickListener = {
                onClickListener.invoke(dialog, it)
            }
        }
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }
    val binding = DataBindingUtil.inflate<StandardListDialogBinding>(context.layoutInflater,
        R.layout.standard_list_dialog, null, false)
    binding.model = model
    dialog.setContentView(binding.root)
    return dialog
}

class StandardListDialogModel {
    val adapter = StandardListAdapter()
    var layoutManager: LinearLayoutManager? = null
}

class StandardListAdapter: RecyclerView.Adapter<StandardListHolder>() {

    var items: Array<String> = arrayOf()
    var onClickListener : ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandardListHolder
            = StandardListHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: StandardListHolder, position: Int) {
        holder.setItem(items[position]) {onClickListener?.invoke(position)}
    }

}

class StandardListHolder(parent: ViewGroup)
    : BindableViewHolder<StandardListDialogItemBinding>(R.layout.standard_list_dialog_item, parent){
    fun setItem(text: String, listener: () -> Unit){
        binding.model = StandardListModel().apply {
            this.text = text
            this.listener = listener
        }
    }
}

class StandardListModel {
    var text: String = ""
    var listener : (() -> Unit)? = null

    fun textClick() {
        listener?.invoke()
    }
}