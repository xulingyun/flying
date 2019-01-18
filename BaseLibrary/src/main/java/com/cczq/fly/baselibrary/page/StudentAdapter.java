package com.cczq.fly.baselibrary.page;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cczq.fly.baselibrary.room.bean.Student;

public class StudentAdapter extends PagedListAdapter<Student,StudentAdapter.StudentHolder> {

    public StudentAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, int i) {
        studentHolder.bind(getItem(i));
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    private static DiffUtil.ItemCallback<Student> diffCallback = new DiffUtil.ItemCallback<Student>() {
        @Override
        public boolean areItemsTheSame(@NonNull Student student, @NonNull Student t1) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Student student, @NonNull Student t1) {
            return false;
        }
    };


    class StudentHolder extends RecyclerView.ViewHolder{

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(Student student){

        }
    }
}
