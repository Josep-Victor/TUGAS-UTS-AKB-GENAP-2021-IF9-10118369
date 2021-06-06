package com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.presenter;

import android.database.Cursor;

import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.model.Note;

public interface NoteInterface {
    // 6 Juni 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);
}
