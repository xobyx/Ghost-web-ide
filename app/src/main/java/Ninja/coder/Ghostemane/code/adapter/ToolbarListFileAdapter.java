package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.color.MaterialColors;
import java.io.File;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import Ninja.coder.Ghostemane.code.ColorAndroid12;
import java.util.List;

public class ToolbarListFileAdapter extends RecyclerView.Adapter<ToolbarListFileAdapter.VH> {

  List<String> _data;
  Context context;
  public String Folder = "";
  protected CallBack back;
  protected boolean isClickNot = false;

  public ToolbarListFileAdapter(List<String> _arr, Context context, CallBack back) {
    this._data = _arr;
    this.context = context;
    this.back = back;
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.instettab, parent, false);
    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _v.setLayoutParams(_lp);
    return new VH(_v);
  }

  @Override
  public void onBindViewHolder(VH holder, final int _position) {
    View _view = holder.itemView;

    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _view.setLayoutParams(_lp);
    holder.textview2.setText(_data.get(_position));

    if (holder.textview2 != null) {
      File file = new File(_data.get(_position).toString());
      if (holder.textview2.getText().toString().startsWith(".")) {
        holder.textview2.setAlpha(file.isHidden() ? 0.5f : 1f);
      }
    }
    holder.itemView.setOnClickListener(
        v -> {
          Log.e("This pos : ", _data.get(_position));
        });
    holder.textview2.setTextColor(
        MaterialColors.getColor(holder.textview2, ColorAndroid12.colorOnSurface));
    holder.imageview1.setColorFilter(
        MaterialColors.getColor(holder.imageview1, ColorAndroid12.colorOnSurface, 0),
        PorterDuff.Mode.SRC_IN);
    holder.textview2.setOnLongClickListener(
        longClick -> {
          isClickNot = true;
          if (isClickNot) {
            if (back != null) {
              back.GoToDir(holder.textview2);
            }
          }

          return false;
        });
    if (!_data.get(_position).equals(Environment.getExternalStorageDirectory().getAbsolutePath())) {
      holder.textview2.setOnClickListener(
          v -> {
            isClickNot = false;
            if (isClickNot) {
              if (back != null) {
                back.GoToTreeFile(v);
                isClickNot = true;
              }
            }
          });
    } else {
      Log.e("EndPath", "");
    }
  }

  @Override
  public int getItemCount() {
    return _data.size();
  }

  public File getFileFromBreadcrumb(List<String> items) {
    String filePath = String.join("/", items);
    return new File(filePath);
  }

  public interface CallBack {
    public void GoToDir(View view);

    public void GoToTreeFile(View view);
  }

  public class VH extends RecyclerView.ViewHolder {
    protected LinearLayout linear2;
    protected TextView textview2;
    protected ImageView imageview1;
    protected View bindview;

    public VH(View v) {
      super(v);
      linear2 = v.findViewById(R.id.linear2);
      textview2 = v.findViewById(R.id.textview2);
      imageview1 = v.findViewById(R.id.imageview1);
      bindview = v;
    }
  }
}
