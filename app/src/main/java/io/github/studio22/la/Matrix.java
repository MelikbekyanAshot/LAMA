package io.github.studio22.la;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends AppCompatActivity {
    ArrayList<Operation> operations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix);

        setInitialData();
        final RecyclerView recyclerView = findViewById(R.id.matrix_operations);

        final OperationAdapter adapter = new OperationAdapter(this, operations, new OperationAdapter.ClickListener() {
            @Override
            public void onPositionClick(int position) {
                Intent intent = new Intent(Matrix.this, CategoryOperation.class);
                intent.putExtra("selected", operations.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        final View view = findViewById(R.id.accelerate); //fail R.id.recyc_background

        SwipeHelper swipeHelper = new SwipeHelper(this, view){

            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        Matrix.this,
                        view,
                        R.drawable.ic_info,
                        Color.parseColor("#F9D19A"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(final int pos) {

                                Snackbar snackbar = Snackbar.make(recyclerView, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                                snackbar.setAction("UNDO", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        recyclerView.scrollToPosition(pos);
                                    }
                                });

                                snackbar.show();
                            }
                        }
                ));
            }
        };
        swipeHelper.attachToRecyclerView(recyclerView);
    }

    private void setInitialData(){
        operations.add(new Operation ("DET |A|"));
        operations.add(new Operation ("A ^ (-1)"));
        operations.add(new Operation ("Транспонирование"));
        operations.add(new Operation ("Ранг матрицы"));
        operations.add(new Operation ("Решение системы уравнений"));
        operations.add(new Operation ("Критерий Сильвестра"));
        operations.add(new Operation ("Поиск собственных значений"));
        operations.add(new Operation ("Поиск собственных векторов"));
        operations.add(new Operation ("Приведение к треугольному виду"));
        operations.add(new Operation ("Приведение к диагональному виду"));
    }

    public void OnClickBackMatrix(View view) {
        Intent intent = new Intent(Matrix.this, MenuNavActivity.class);
        startActivity(intent);
    }
}
