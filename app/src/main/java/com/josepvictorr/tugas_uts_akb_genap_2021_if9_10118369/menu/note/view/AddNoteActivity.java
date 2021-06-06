package com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.R;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.model.Note;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.presenter.DBHelperNote;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.presenter.NoteInterface;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {
    // 6 Juni 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    ImageButton button;
    EditText editTitle;
    EditText editCategory;
    EditText editDesc;
    Button addButton;
    Button deleteButton;
    TextView titleAdd;

    private NoteInterface noteInterface;
    Note note = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        getSupportActionBar().hide();
        note = (Note) getIntent().getSerializableExtra("Note");
        button = findViewById(R.id.back);
        editTitle = findViewById(R.id.title);
        editCategory = findViewById(R.id.category);
        editDesc = findViewById(R.id.desc);
        addButton = findViewById(R.id.buttonadd);
        deleteButton = findViewById(R.id.buttondelete);
        titleAdd = findViewById(R.id.title_add);
        noteInterface = new DBHelperNote(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (note == null){
            deleteButton.setVisibility(View.GONE);

            addButton.setOnClickListener(v -> {
                    if (editTitle.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Judul Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (editCategory.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Kategori Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (editDesc.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Isi Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    }
                    Date d = new Date();
                    CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm", d.getTime());
                    Note n = new Note(
                            d.getTime() + "",
                            editTitle.getText().toString(),
                            editCategory.getText().toString(),
                            editDesc.getText().toString() ,
                            "di buat pada " + date + ""
                    );

                    noteInterface.create(n);
                    finish();
                    Toast.makeText(this, "Catatan berhasil di tambah", Toast.LENGTH_SHORT).show();
            });
        } else {
            editTitle.setText(note.getTitle());
            editCategory.setText(note.getCategory());
            editDesc.setText(note.getDesc());

            deleteButton.setVisibility(View.VISIBLE);
            titleAdd.setText("Edit Catatan");

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }

                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMMM yyyy HH:mm",d.getTime());

                note.setTitle(editTitle.getText().toString());
                note.setCategory(editCategory.getText().toString());
                note.setDesc(editDesc.getText().toString());
                note.setDate("terakhir di edit " + date + "");
                noteInterface.update(note);
                finish();
                Toast.makeText(this, "Catatan berhasil di edit", Toast.LENGTH_SHORT).show();
            });
        }

        deleteButton.setOnClickListener(v-> {
            noteInterface.delete(note.getId());
            finish();
            Toast.makeText(this, "Catatan berhasil di hapus", Toast.LENGTH_SHORT).show();
        });
    }
}