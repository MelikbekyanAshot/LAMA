package io.github.studio22.lama.ui.achievements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import io.github.studio22.lama.R;

public class AchievementFragment extends Fragment {

    /*String[] achievementsName = {
            "Первопроходец", "Знаток", "Модник",
            "Исследователь", "Наблюдатель", "Ламовед ур.1",
            "Ламовед ур.2", "Ламовед ур.3", "Ламовед ур.4" };

    int[] achievementsImage = {
            R.drawable.logo_new, R.drawable.one_matrix, R.drawable.logo_new,
            R.drawable.logo_new, R.drawable.logo_new, R.drawable.logo_new,
            R.drawable.logo_new, R.drawable.logo_new, R.drawable.logo_new };*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_achiev, container, false);

        return root;
    }
}