package com.fjw.myapp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fjw.myapp.model.MainListModel;
import com.fjw.myapp.R;
import com.fjw.myapp.util.ToastUtil;

import java.util.List;

/**
 * 首页adapter
 */
public class MainListAdapter extends
		RecyclerView.Adapter<MainListAdapter.ViewHolder>  {




	public interface OnItemClickLitener
	{
		void onItemClick(View view, int position);
	}

	private OnItemClickLitener mOnItemClickLitener;

	public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
	{
		this.mOnItemClickLitener = mOnItemClickLitener;
	}

	private LayoutInflater mInflater;
	private List<MainListModel> mDatas;
	private Context context;
	public MainListAdapter(Context context, List<MainListModel> datats)
	{
		this.context=context;
		mInflater = LayoutInflater.from(context);
		mDatas = datats;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		public ViewHolder(View arg0)
		{
			super(arg0);
		}

		ViewPager mVierPager;
		TextView mTxt1;
		TextView mTxt2;
	}

	@Override
	public int getItemCount()
	{
		return mDatas.size();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup,  int i)
	{
		View view = mInflater.inflate(R.layout.layout_main_list_item,
				viewGroup, false);
		final ViewHolder viewHolder = new ViewHolder(view);
		viewHolder.mVierPager = (ViewPager ) view
				.findViewById(R.id.viewPager);
		viewHolder.mTxt1= (TextView) view.findViewById(R.id.text1);
		viewHolder.mTxt2= (TextView) view.findViewById(R.id.text2);




		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final ViewHolder viewHolder, final int i)
	{
		//viewHolder.mVierPager.setImageResource(mDatas.get(i));
		myAdapter adapter = new myAdapter(context,i);
		viewHolder.mTxt1.setText(mDatas.get(i).getTitleName());
		viewHolder.mVierPager.setAdapter(adapter);
		if (mOnItemClickLitener != null)
		{
			viewHolder.itemView.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mOnItemClickLitener.onItemClick(viewHolder.itemView, i);
				}
			});

		}

	}

	class myAdapter extends PagerAdapter{

		private final Context context;
        private int list;
		public myAdapter(Context context,int list) {
			
			this.context = context;
			this.list=list;
		}

		@Override
		public int getCount() {
			return 6;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view==object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			View ret = null;
			ImageView imageView = new ImageView(context);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		    imageView.setBackgroundResource(R.mipmap.demo_one);
					ret = imageView;
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ToastUtil.showShort(context,"点击"+list+"是第"+position+"张图片");
				}
			});
			container.addView(ret);

			return ret;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

}
