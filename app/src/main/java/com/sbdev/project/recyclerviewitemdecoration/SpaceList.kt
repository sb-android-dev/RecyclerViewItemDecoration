package com.sbdev.project.recyclerviewitemdecoration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.sbdev.project.recyclerview_item_decoration.SpaceDecoration
import com.sbdev.project.recyclerview_item_decoration.Orientation
import com.sbdev.project.recyclerviewitemdecoration.databinding.ActivitySpaceListBinding

class SpaceList : AppCompatActivity() {

    private lateinit var binding: ActivitySpaceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpaceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val horizontalItemDecoration = SpaceDecoration(this).apply {
            orientation = Orientation.HORIZONTAL
            endOffset = R.dimen._4dp
            topOffset = R.dimen._4dp
            bottomOffset = R.dimen._4dp
            lastOffset = R.dimen.recycler_last_offset
        }
        binding.rvHorizontalList.addItemDecoration(horizontalItemDecoration)
        binding.rvHorizontalList.adapter = RecyclerListAdapter(getPersonList(), RecyclerView.HORIZONTAL)

        val verticalItemDecoration = SpaceDecoration(this).apply {
            orientation = Orientation.VERTICAL
            endOffset = R.dimen._4dp
            startOffset = R.dimen._4dp
            topOffset = R.dimen._4dp
            lastOffset = R.dimen.recycler_last_offset
        }
        binding.rvVerticalList.addItemDecoration(verticalItemDecoration)
        binding.rvVerticalList.adapter = RecyclerListAdapter(getPersonList(), RecyclerView.VERTICAL)
    }

    private fun getPersonList(): List<PersonInfo>{
        val persons: MutableList<PersonInfo> = mutableListOf()

        persons.add(PersonInfo("Stewart Nolan", "Elementum integer enim neque volutpat ac. Orci nulla pellentesque dignissim enim sit amet venenatis urna. Interdum varius sit amet mattis vulputate enim nulla aliquet porttitor."))
        persons.add(PersonInfo("Harry Davies", "Ut porttitor leo a diam sollicitudin tempor. Felis eget nunc lobortis mattis aliquam. Risus nec feugiat in fermentum. Varius duis at consectetur lorem donec massa sapien faucibus et."))
        persons.add(PersonInfo("Richard Edmunds", "Convallis tellus id interdum velit laoreet id donec ultrices tincidunt. Turpis nunc eget lorem dolor sed viverra ipsum nunc. In massa tempor nec feugiat nisl pretium. Et molestie ac feugiat sed."))
        persons.add(PersonInfo("Tracey Edmunds", "Elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue. Praesent semper feugiat nibh sed pulvinar proin. Auctor eu augue ut lectus arcu bibendum at varius vel. In metus vulputate eu scelerisque felis."))
        persons.add(PersonInfo("Ryan Paterson", "Eleifend mi in nulla posuere sollicitudin. Aliquam nulla facilisi cras fermentum odio eu feugiat pretium. Proin nibh nisl condimentum id. Lobortis elementum nibh tellus molestie nunc non."))
        persons.add(PersonInfo("Adam Scott", "Arcu non odio euismod lacinia at quis risus. Feugiat nibh sed pulvinar proin gravida. Eget est lorem ipsum dolor sit amet consectetur. Pharetra diam sit amet nisl suscipit adipiscing bibendum est ultricies."))
        persons.add(PersonInfo("Lillian Wilkins", "Metus dictum at tempor commodo ullamcorper a lacus. Convallis posuere morbi leo urna molestie at elementum eu facilisis. Purus ut faucibus pulvinar elementum integer enim."))
        persons.add(PersonInfo("Lillian Tucker", "Nunc lobortis mattis aliquam faucibus purus in massa. Nulla posuere sollicitudin aliquam ultrices sagittis orci a. Nec nam aliquam sem et tortor consequat id. Vitae semper quis lectus nulla at volutpat diam ut."))
        persons.add(PersonInfo("Sarah Robertson", "Sem integer vitae justo eget magna. Congue nisi vitae suscipit tellus mauris a. Sit amet nisl suscipit adipiscing bibendum est. In iaculis nunc sed augue lacus viverra. At volutpat diam ut venenatis."))
        persons.add(PersonInfo("John Watson", "Nam aliquam sem et tortor. Nisl nunc mi ipsum faucibus vitae aliquet nec. Aenean euismod elementum nisi quis eleifend quam adipiscing vitae. Eget felis eget nunc lobortis mattis aliquam faucibus purus in."))

        return persons
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}