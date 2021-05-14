package com.application.aroohfeen.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.aroohfeen.R;
import com.application.aroohfeen.adapter.MainSectionsAdapter;
import com.application.aroohfeen.model.MainSectionsItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionsFragment extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private MainSectionsAdapter mainSectionsAdapter;
    private List<MainSectionsItem> mainSectionsList;
    private MainSectionsItem mainSectionsItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sections, container, false);

        mainRecyclerView();

        return view;
    }

    public void mainRecyclerView() {
        recyclerView = view.findViewById(R.id.recyclerview_main_products_sections);
        setUpMySectionsList();

        mainSectionsList = new ArrayList<>();

        for(int i = 0 ; i < 9 ; i++){
            mainSectionsItem = new MainSectionsItem();
            mainSectionsItem.setSectionName("Section " + i);
            mainSectionsItem.setSectionImage(R.drawable.image1);
            mainSectionsList.add(mainSectionsItem);
        }

        mainSectionsAdapter = new MainSectionsAdapter(getContext().getApplicationContext()
                , mainSectionsList);
        recyclerView.setAdapter(mainSectionsAdapter);
    }
    private void setUpMySectionsList() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
    }
}
