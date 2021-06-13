package com.implude.niche.presentation.main.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.implude.niche.R
import com.implude.niche.databinding.FragmentUserBinding
import com.implude.niche.domain.models.CategoryModel
import com.implude.niche.domain.models.CommentModel
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.TagModel
import com.implude.niche.domain.models.UserModel
import com.implude.niche.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.heartRecyclerview.apply {
            adapter = HeartedPlaceAdapter(requireContext()).apply {
                items = listOf(
                    PlaceModel(
                        name = "달달",
                        id = "id",
                        heartQuantity = 5,
                        tags = listOf(TagModel("sdf", "sdf", null)),
                        comments = listOf(
                            CommentModel(
                                "sdf",
                                listOf("sdf", "sdf"),
                                null,
                                UserModel("sdf", "sdf", "sdf")
                            )
                        ),
                        location = LocationModel(1.1, 1.1),
                        category = CategoryModel("id", "label"),
                        owner = null,
                        verified = true,
                        hearted = false
                    ),
                    PlaceModel(
                        name = "달달",
                        id = "id",
                        heartQuantity = 5,
                        tags = listOf(TagModel("sdf", "sdf", null)),
                        comments = listOf(
                            CommentModel(
                                "sdf",
                                listOf("sdf", "sdf"),
                                null,
                                UserModel("sdf", "sdf", "sdf")
                            )
                        ),
                        location = LocationModel(1.1, 1.1),
                        category = CategoryModel("id", "label"),
                        owner = null,
                        verified = true,
                        hearted = false
                    ),
                    PlaceModel(
                        name = "달달",
                        id = "id",
                        heartQuantity = 5,
                        tags = listOf(TagModel("sdf", "sdf", null)),
                        comments = listOf(
                            CommentModel(
                                "sdf",
                                listOf("sdf", "sdf"),
                                null,
                                UserModel("sdf", "sdf", "sdf")
                            )
                        ),
                        location = LocationModel(1.1, 1.1),
                        category = CategoryModel("id", "label"),
                        owner = null,
                        verified = true,
                        hearted = false
                    ),
                    PlaceModel(
                        name = "달달",
                        id = "id",
                        heartQuantity = 5,
                        tags = listOf(TagModel("sdf", "sdf", null)),
                        comments = listOf(
                            CommentModel(
                                "sdf",
                                listOf("sdf", "sdf"),
                                null,
                                UserModel("sdf", "sdf", "sdf")
                            )
                        ),
                        location = LocationModel(1.1, 1.1),
                        category = CategoryModel("id", "label"),
                        owner = null,
                        verified = true,
                        hearted = false
                    ),
                )
            }
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}