package io.github.rosemoe.sora.langs.html;

import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.util.List;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class ErrorManagerHtml {
    public static int[] setErrorSpan(TextAnalyzeResult colors, int line, int column) {
        int lineCount = colors.getSpanMap().size();
        int realLine = line - 1;
        List<Span> spans = colors.getSpanMap().get(Math.min(realLine, lineCount - 1));

        int[] end = new int[2];
        end[0] = Math.min(realLine, lineCount - 1);

        if (realLine >= lineCount) {
            Span span = Span.obtain(0, EditorColorScheme.PROBLEM_ERROR);
            span.problemFlags = Span.FLAG_ERROR;
            colors.add(realLine, span);
            end[0]++;
        } else {
            Span last = null;
            for (int i = 0; i < spans.size(); i++) {
                Span span = spans.get(i);
                if (last != null) {
                    if (last.column <= column - 1 && span.column >= column - 1) {
                        span.problemFlags = Span.FLAG_ERROR;
                        last.problemFlags = Span.FLAG_ERROR;
                        end[1] = last.column;
                        break;
                    }
                }
                if (i == spans.size() - 1 && span.column <= column - 1) {
                    span.problemFlags = Span.FLAG_ERROR;
                    end[1] = span.column;
                    break;
                }
                last = span;
            }
        }
        return end;
    }

    /**
     * Used in xml diagnostics where line is only given
     */
    public static void setErrorSpan(TextAnalyzeResult colors, int line) {
        int lineCount = colors.getSpanMap().size();
        int realLine = line - 1;
        List<Span> spans = colors.getSpanMap().get(Math.min(realLine, lineCount - 1));

        for (Span span : spans) {
            span.problemFlags = Span.FLAG_ERROR;
        }
    }
}
