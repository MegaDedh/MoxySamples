package ru.asshands.softwire.moxysample_1.migration;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface ViewWithoutStrategy extends MvpView {

    void noStrategyMethod();
}
