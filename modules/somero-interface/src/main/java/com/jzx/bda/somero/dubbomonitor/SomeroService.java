package com.jzx.bda.somero.dubbomonitor;


import java.io.IOException;
import java.util.List;

import com.jzx.bda.somero.Span;

public interface SomeroService {
    boolean push(List<Span> span) throws IOException;
}