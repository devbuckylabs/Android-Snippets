
//MainActivity.java

recyclerView=findViewById(R.id.recyclerView);
recyclerView.hasFixedSize();
recyclerView.setLayoutManager(new LinearLayoutManager(this));
 MyAdapter adapter=new MyAdapter(context,apks);
recyclerView.setAdapter(adapter);

//MyAdapter.java

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Apk> apks=new ArrayList<>();
    Context context;

    public MyAdapter(Context context,List<Apk> apks) {
        this.apks = apks;
        this.context = context;

    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {

     Apk apk=apks.get(i);
     viewHolder.appName.setText(apk.getAppName());
     viewHolder.appIcon.setImageDrawable(apk.getAppIcon());

    }

    @Override
    public int getItemCount() {
        return apks.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView appName;
        ImageView appIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appName=itemView.findViewById(R.id.textView);
            appIcon=itemView.findViewById(R.id.imageView);
        }
    }
