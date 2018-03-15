package com.example.lxy.trade;

import com.hyphenate.easeui.ui.EaseConversationListFragment;

/**
 * 项目名：Trade
 * 包名：com.example.lxy.trade
 * 文件名：MyFragment2
 * 创建者：lxy
 * 创建时间：2018/3/14
 * 描述：消息界面
 */
public class MyFragment2 extends EaseConversationListFragment {

    /*public MyFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lianxiren,container,false);
        return view;
    }*/

    @Override
    protected void initView() {
        super.initView();
        hideTitleBar();
        initData();
    }


    private void initData() {
        // run in a second
        final long timeInterval = 10000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    conversationListView.refresh();
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
